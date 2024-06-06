package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class DbAdapter<T> implements IDbAdapter<T> {
    private DbConnection<T> connection;
    private static final String prefix = "select * from ";

    public DbAdapter(DbConnection dbConnection) {
        this.connection = dbConnection;
    }

    public List<T> get(String entity, List<Filter> filters) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(entity).append(" where ");

        //where operand1 operator operand2
//        for(int i=0; i<filters.size(); i++) {
//            Filter filter = filters.get(i);
//            sb.append(filter.operand1 + " " + filter.operator + " " + filter.operand2);
//            if(i != filters.size() - 1) {
//                sb.append(" AND ");
//            }
//        }
//
//        filters.stream().forEach((filter) -> {
//            sb.append(filter.operand1 + " " + filter.operator + " " + filter.operand2);
//            int i = filters.indexOf(filter);
//            if(i != filters.size() - 1) {
//                sb.append(" AND");
//            }
//        });

        String intermediateQuery = filters.stream()
                .map((filter) -> filter.operand1 + " " + filter.operator + " " + filter.operand2)
                .collect(Collectors.joining(" AND "));

        sb.append(intermediateQuery + ";");

        return connection.submit(sb.toString());
    }
}
