# keycloak-mysql-federation

Just a simple MySQL Federation for ext-lookup.

### Setup

Build the application with `mvn clean install`. This will generate a `target/keycloak-jh7-federation-1.0-SNAPSHOT-jar-with-dependencies.jar` file.

Copy the file to keycloak deployments: `/opt/jboss/keycloak/standalone/deployments/`. Keycloak should be able to detect and deploy the jar file.

### Configuration

Following properties are provided:

- Database Host: The hostname to connect to MySQL
- Database Port: The port number to connect to MySQL
- Database: The database which store the `users` table contain information
- Database Username: The username with access to this database
- Database Password: The password to login

### Behavior

1. User listing:

```sql
$ SELECT phone as username, first_name as firstName, last_name as lastName from users
```

2. User Login:

```sql
$ SELECT password FROM users WHERE phone = ?
```

Password is store as plain text.

TBD: Add more hashing function to support password encryption

Other features are omit, as this federation act as a read-only DB for listing and login only.

- Update user
- Create user
- Delete user
- Change password for user
