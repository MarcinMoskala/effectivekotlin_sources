package f_C5_Item35.s_1

interface DatabaseClient { /* ... */ }
class PostgresDatabaseClient : DatabaseClient { /* ... */ }

interface UserRepository { /* ... */ }
class DatabaseUserRepository(
    private val databaseClient: DatabaseClient
) : UserRepository { /* ... */ }

interface EmailClient { /* ... */ }
class MailchimpEmailClient : EmailClient { /* ... */ }

interface EmailService { /* ... */ }
class MailchimpEmailService(
    private val emailClient: EmailClient
) : EmailService { /* ... */ }

class UserService(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) { /* ... */ }
