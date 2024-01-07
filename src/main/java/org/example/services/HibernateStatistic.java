package org.example.services;

import org.hibernate.stat.Statistics;

public class HibernateStatistic {

    public void sOutStatistics(Statistics statistics, String point) {
        System.out.println(
                String.format("\nМомент вызова: %s \n %s - количество завершенных транзакций: %d \n количество открытых сессий: %d \n количество закрытых сессий: %d \n количество добавленных сущностей: %d \n количество обновленных сущностей: %d",
                        point,
                        this.getClass().getSimpleName(),
                        statistics.getTransactionCount(),
                        statistics.getSessionOpenCount(),
                        statistics.getSessionCloseCount(),
                        statistics.getEntityInsertCount(),
                        statistics.getEntityUpdateCount()));

    }
}
