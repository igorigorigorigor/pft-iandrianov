D:
cd D:\Git\pft-iandrianov\addressbook-selenium-testsuit
del groups.txt
java -cp bin;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream-1.4.6.jar;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xmlpull-1.1.3.1.jar;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xpp3_min-1.1.4c.jar com.example.tests.GroupDataGenerator 5 groups.txt xml
java -cp bin;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream-1.4.6.jar;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xmlpull-1.1.3.1.jar;D:\Study\PFT\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xpp3_min-1.1.4c.jar;D:\Study\PFT\selenium-server-standalone-2.37.0.jar -DconfigFile=firefox.properties org.testng.TestNG testng-groupcreationtests.xml