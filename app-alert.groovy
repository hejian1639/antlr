import static com.riil.baymax.engine.AggregationEngine.alert


alert('app') {

    groupBy('app_id', 'loc_id')

    eval {
        http_failed_count = probe_http.countIf(error_code != Null)
        http_success_count = http_status.sum(count1xx + count2xx + count3xx)

    }

    trigger {
        (http_failed_count > 3) && (http_success_count == 0)
    }

}
