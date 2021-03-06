package main;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

/**
 * Generate the DB Migration.
 */
public class GenerateDbMigration {

  /**
   * Generate the next "DB schema DIFF" migration.
   * <p>
   * These migration are typically run using FlywayDB, Liquibase
   * or Ebean's own built in migration runner.
   * </p>
   */
  public static void main(String[] args) throws IOException {

    // optionally specify the version and name
    //System.setProperty("ddl.migration.version", "1.1");
    //System.setProperty("ddl.migration.name", "add bars");

    // generate a migration using drops from a prior version
    //System.setProperty("ddl.migration.pendingDropsFor", "1.2");

    DbMigration dbMigration = DbMigration.create();
    dbMigration.setPlatform(Platform.POSTGRES);
//    dbMigration.setStrictMode(false);

    // generate the migration ddl and xml
    // ... with EbeanServer in "offline" mode
    dbMigration.generateMigration();
  }
}