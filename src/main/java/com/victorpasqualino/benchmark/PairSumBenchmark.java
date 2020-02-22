package com.victorpasqualino.benchmark;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Fork(value = 1, jvmArgs = {"-Xms256m", "-Xmx256m"})
public class PairSumBenchmark {

    @Param({"10", "5000", "30000", "100000", "1000000"})
    public int length;

    private int[] array;
    private int sum;
    private static final long seed = System.currentTimeMillis();

    @Setup(Level.Iteration)
    public void setup() {
        Random rd = new Random(seed);
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt();
        }
        sum = rd.nextInt();
    }

    // @Benchmark
    // Nem vale a pena testar, demora muito
    public void testPairSumN2() {
        PairSum.n2(array, sum);
    }

    @Benchmark
    public void testPairSumNLOGN() {
        PairSum.nlogn(array, sum);
    }

    @Benchmark
    public void testPairSumN() {
        PairSum.n(array, sum);
    }

    @Benchmark
    public void testPairSumBestN() {
        PairSum.bestN(array, sum);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PairSumBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

}