## note
`@Scheduled` 
1. `fixedRate`, which specifies the interval between method invocations measured from the start time of each invocation
2. `fixedDelay`, which specifies the interval between invocations measured from the completion of the task.
3. `@Scheduled(cron=". . .")` expressions for more sophisticated task scheduling [^1].
4. `@EnableScheduling` ensures that a background task executor is created. Without it, nothing gets scheduled.


##  cron expressions
```html
Date sequence generator for a Crontab pattern, allowing clients to specify a pattern that the sequence matches.
The pattern is a list of six single space-separated fields: representing second, minute, hour, day, month, weekday. Month and weekday names can be given as the first three letters of the English names.

Example patterns:

 "0 0 * * * *" = the top of every hour of every day.
 "*/10 * * * * *" = every ten seconds.
 "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
 "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
 "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
 "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
 "0 0 0 25 12 ?" = every Christmas Day at midnight
```

[^1]:https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
