import static com.riil.baymax.engine.AggregationEngine.alert

alert('cpu') {

    from 'cpu'

    groupBy 'host'

    where { cpu == 'cpu-total' }

    eval {
        used = average(100.0 - usage_idle)
    }

    trigger {
        used > 1
    }

}
