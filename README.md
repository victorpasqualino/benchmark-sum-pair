# benchmark-sum-pair

# Máquina 

Linux vpnote 5.5.4-arch1-1 #1 SMP PREEMPT Sat, 15 Feb 2020 00:36:29 +0000 x86_64 GNU/Linux
JVM: openjdk 13.0.2 2020-01-14
OpenJDK Runtime Environment (build 13.0.2+8)
OpenJDK 64-Bit Server VM (build 13.0.2+8, mixed mode)

# Resultados

Benchmark                          (length)  Mode  Cnt      Score       Error  Units
PairSumBenchmark.testPairSumBestN        10  avgt   20      1.845 ±     4.331  us/op
PairSumBenchmark.testPairSumBestN      5000  avgt   20    724.435 ±   133.503  us/op
PairSumBenchmark.testPairSumBestN     30000  avgt   20   3412.727 ±  1069.642  us/op
PairSumBenchmark.testPairSumBestN    100000  avgt   20   7635.139 ±   316.326  us/op
PairSumBenchmark.testPairSumBestN   1000000  avgt   20  87735.343 ±   121.177  us/op
PairSumBenchmark.testPairSumN            10  avgt   20      7.084 ±     8.139  us/op
PairSumBenchmark.testPairSumN          5000  avgt   20    977.356 ±   259.573  us/op
PairSumBenchmark.testPairSumN         30000  avgt   20   4150.903 ±  1518.960  us/op
PairSumBenchmark.testPairSumN        100000  avgt   20  20029.627 ± 10530.013  us/op
PairSumBenchmark.testPairSumN       1000000  avgt   20  12886.556 ±  9033.109  us/op
PairSumBenchmark.testPairSumNLOGN        10  avgt   20      2.234 ±     1.287  us/op
PairSumBenchmark.testPairSumNLOGN      5000  avgt   20   1064.895 ±   162.869  us/op
PairSumBenchmark.testPairSumNLOGN     30000  avgt   20   4140.750 ±   690.458  us/op
PairSumBenchmark.testPairSumNLOGN    100000  avgt   20  12127.639 ±   642.776  us/op
PairSumBenchmark.testPairSumNLOGN   1000000  avgt   20  86335.860 ±    89.710  us/op

# Conclusão 

A solução apresentada como melhor "testPairSumN" só é melhor para arrays maiores que 100000, além de que ocupa mais memória. Mesmo assim é uma boa solução. 
