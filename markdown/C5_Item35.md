```
class UserService {
    private val userRepository = DatabaseUserRepository()
    private val emailService = MailchimpEmailService()
    
    fun registerUser(email: String, password: String) {
        val user = userRepository.createUser(email,password)
        emailService.sendEmail(user.email, "Welcome!")
    }
}
```


```
class UserService(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun registerUser(email: String, password: String) {
        val user = userRepository.createUser(email,password)
        emailService.sendEmail(user.email, "Welcome!")
    }
}
```


```
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
```


```
val userModule = module {
    single<DatabaseClient> { PostgresDatabaseClient() }
    single<UserRepository> { DatabaseUserRepository(get()) }
    single<EmailClient> { MailchimpEmailClient() }
    single<EmailService> { MailchimpEmailService(get()) }
    single { UserService(get(), get()) }
}
```


```
val userRepo: UserRepository by inject()
val userService: UserService = get()
```