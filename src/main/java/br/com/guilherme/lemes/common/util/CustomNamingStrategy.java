package br.com.guilherme.lemes.common.util;

import org.hibernate.cfg.ImprovedNamingStrategy;


public class CustomNamingStrategy extends ImprovedNamingStrategy {

    private static final long serialVersionUID = 8402377910968967292L;

    private String currentClass;

    private Prefix currentPrefix;

    private String[] packageNames;

    @Override
    public String classToTableName(String className) {
        setCurrentClass(className);

        for (String name : packageNames) {
            try {
                currentPrefix = Class.forName(name + "." + className).getAnnotation(Prefix.class);
            } catch (ClassNotFoundException e) {
                // do nothing
            }
        }

        if (currentPrefix == null) {
            System.out.println(className + ": sem prefixo");
            return null;
        }

        return currentPrefix.table() + "_" + tableName(className);
    }

    @Override
    public String collectionTableName(String ownerEntity,
                                      String ownerEntityTable, String associatedEntity,
                                      String associatedEntityTable, String propertyName) {

        String associatedTable = "";

        if (associatedEntityTable == null) {
            associatedTable = propertyName;
        } else {

            associatedTable = tableName(associatedEntityTable);
        }

        return currentPrefix.table() + "_" + tableName(ownerEntityTable) + "_" + associatedTable;

    }

    @Override
    public String joinKeyColumnName(String joinedColumn, String joinedTable) {
        return currentPrefix.column() + "_" + tableName(joinedTable) + "_" + tableName(joinedColumn);
    }

    @Override
    public String foreignKeyColumnName(String propertyName,
                                       String propertyEntityName, String propertyTableName,
                                       String referencedColumnName) {

        for (String name : packageNames) {
            try {
                String fkPrefix = Class.forName(name + "." + propertyTableName).getAnnotation(Prefix.class).column();
                return fkPrefix + "_" + tableName(referencedColumnName);
            } catch (ClassNotFoundException e) {
                // dO nOTHING
            }
        }

        return null;
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(currentPrefix.column() + "_" + propertyName);
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public void setPackageNames(String[] packageNames) {
        this.packageNames = packageNames;
    }
}
