# JavaGarbageCollectorTest

Trying to see how the Java garbage collector works and whether it can be messed with.
Supposedly the JVM can ignore manual GC requests; this does appear to be true.
However, most requests seemed to be honored and carried out.

```bash
java -XX:+PrintGCDetails JavaGarbageCollectorTest/JavaGarbageCollectorTest.java > output.txt
```
