package ru.job4j.ex;

public class UserStore {

    /**
     * 1. если пользователя не нашли в списке, то кинуть исключение UserNotFoundException
     * 2. В блоке catch(UserNotFoundException) - должно быть выведено на консоль сообщение,
     *    что пользователя не найдено.
     */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                System.out.println("User is on the list");
                user = users[i];
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    /**
     * 1. если пользователь не валидный или если имя пользователя состоит из менее трех символов,
     *    то кинуть исключение UserInvalidException
     * 2. Метод validate принимает аргумент user. У объекта user есть метод isValid().
     *    Если он false, то нужно выкинуть исключение UserInvalidException.
     * 3. Так же в этом методе нужно проверить, что у объекта user количество символов в поле username меньше 3.
     *    Если оно меньше, то нужно выкинуть исключение UserInvalidException.
     *    Для этого нужно воспользоваться методом String.length().
     * 4. В блоке  catch(UserInvalidException) - должно быть выведено на консоль сообщение,
     *    что пользователь не валидный.
     */
    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return false;
    }

    /**
     * main - поправить код за счет использования try-catch с множественным блоком catch.
     */
    public static void main(String[] args) throws UserNotFoundException {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
                    new User("Stanislav Kufarev", false),
                    new User("Boris Korolev", true)
            };
            User user = findUser(users, "Stanislav Kufarev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
