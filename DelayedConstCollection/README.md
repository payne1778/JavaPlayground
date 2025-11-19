# DelayedConstCollection

Saw that the `Collections` class had a `unmodifiableList()` method. Super cool.
Had an idea to use this so that you could mutate a list up to a certain point,
and then all modifications afterwards would be banned. Might be useful in a
security context.

```bash
java DelayedConstCollection/DelayedConstCollection.java
```
