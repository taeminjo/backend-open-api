package com.nangpun.backend.infrastructure.jpa

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class ReplicationRoutingDataSource: AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any? {
        val isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly()
        return if (isReadOnly) RoutingDataSourceLookupKey.READ else RoutingDataSourceLookupKey.WRITE
    }
}