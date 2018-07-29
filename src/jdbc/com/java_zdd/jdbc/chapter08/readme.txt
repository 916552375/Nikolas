第八章 使用元数据分析数据库
第一节；
DatabaseMetaData可以得到数据库的一些基本信息，包括数据库的名称、版本、以及得到表的信息。
String getDatabaseProductName() 获取此数据库产品的名称。
int getDriverMajorVersion() 获取此JDBC驱动程序的主版本号；
int getDriverMinorVersion() 获取此JDBC驱动程序的次版本号。
第二节：使用ResultSetMeteData获取ResultSet对象中的信息
ResultSetMetaData可获取关于ResultSet对象中列的基本信息；
int getColumnName(int column)   获取指定列的名称；
int getColumnTypeName(int column)   获取指定列的SQL类型名称