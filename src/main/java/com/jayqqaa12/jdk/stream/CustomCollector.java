package com.jayqqaa12.jdk.stream;

import com.jayqqaa12.model.Song;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class CustomCollector {

    /**
     * 格式化  v1.0
     * 我们原有的代码是这样的
     * 看起来好像没啥问题
     * 还是好像不太方便重用
     *
     * @param list
     * @return
     */
    public String getName(List<Song> list) {

        StringBuffer sb = new StringBuffer("[");

        for (Song song : list) {
            if (sb.length() > 1) sb.append(",");
            sb.append(song.getName());
        }
        return sb.toString();
    }


    /**
     * 格式化  v2.0
     * <p>
     * 只是用了jdk8的特性
     * 但是
     * 好像并没有太大改进
     *
     * @param list
     * @return
     */
    public String getName2(List<Song> list) {

        StringBuffer sb = new StringBuffer("[");

        list.stream()
                .map(Song::getName)
                .forEach(name -> {
                    if (sb.length() > 1) sb.append(",");
                    sb.append(name);
                });

        return sb.toString();
    }

    /**
     * 格式化  v3.0
     * <p>
     * <p>
     * foreach的操作似乎太过笨重
     * 我们使用reduce 完成这个过程
     * <p>
     * 但是似乎让代码更糟糕啦
     *
     * @param list
     * @return
     */
    public String getName3(List<Song> list) {

        return list.stream()
                .map(Song::getName)
                .reduce(new StringBuilder(), (builder, name) -> {
                    if (builder.length() > 0) builder.append(",");
                    builder.append(name);
                    return builder;
                }, (left, right) -> left.append(right)).insert(0, "[").append("]")
                .toString();
    }

    /**
     * 格式化 v4.0
     * <p>
     * 我们用StringCombiner
     * 来代替原先的操作
     * 来隐藏杂乱无章的细节
     * <p>
     * 看起来是不是好了点
     *
     * @param list
     * @return
     */
    public String getName4(List<Song> list) {

        return list.stream().map(Song::getName)
                .reduce(new StringCombiner(",", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge).toString();

    }


    /**
     * 格式化 v5.0
     * <p>
     * 之前的代码看起来不错了
     * 但是还不能在程序中重用
     * 我们自定义一个收集器
     * 这样看起来是不是更好了
     *
     * @param list
     * @return
     */
    public String getName5(List<Song> list) {

        return list.stream().map(Song::getName).collect(new StringCollector(".", "[", "]"));

    }


}


class StringCombiner {

    private final String delim;
    private final String prefix;
    private final String suffix;
    private final StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    private boolean areAtStart() {
        return builder.length() == 0;
    }

    public StringCombiner merge(StringCombiner other) {
        if (other.builder.length() > 0) {
            if (areAtStart()) {
                builder.append(prefix);
            } else {
                builder.append(delim);
            }
            builder.append(other.builder, prefix.length(), other.builder.length());
        }
        return this;
    }

    @Override
    public String toString() {
        if (areAtStart()) {
            builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString();
    }

}

class StringCollector implements Collector<String, StringCombiner, String> {

    private final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }

    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }


    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }


    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}