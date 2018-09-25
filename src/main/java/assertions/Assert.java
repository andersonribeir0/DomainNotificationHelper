package assertions;

import notifications.DomainNotification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assert {

    public static DomainNotification length(String text, int min, int max, String key, String val)
    {
        long length = text.trim().length();

        return (length < min || length > max)
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification matches(String pattern, String text, String key, String val)
    {
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(text);
        return (!matcher.find())
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification notEmpty(String text, String key, String val)
    {
        return (isNullOrWhitespace(text))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isNotNull(Object obj, String key, String val)
    {
        return (obj == null)
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isNull(Object obj, String key, String val)
    {
        return (obj != null)
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isTrue(boolean obj, String key, String val)
    {
        return (!obj)
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification areEquals(Object anObject1, Object anObject2, String key, String val)
    {
        return (!(anObject1 == anObject2))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isGreaterThan(int value1, int value2, String key, String val)
    {
        return (!(value1 > value2))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isGreaterThan(double value1, double value2, String key, String val)
    {
        return (!(value1 > value2))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isGreaterOrEqualThan(int value1, int value2, String key, String val)
    {
        return (!(value1 >= value2))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification isLessOrEqualThan(double value1, double value2, String key, String val)
    {
        return (!(value1 <= value2))
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification regexMatch(String value, String regex, String key, String val)
    {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(value);
        return (!matcher.matches())
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification emailIsValid(String email, String key, String val)
    {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        return (!matcher.find())
                ? new DomainNotification(key, val)
                : null;
    }

    public static DomainNotification urlIsValid(String url, String key, String val)
    {
        if (isNullOrEmpty(url))
            return null;

        Pattern VALID_URL_REGEX =
                Pattern.compile("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_URL_REGEX.matcher(url);
        return (!matcher.find())
                ? new DomainNotification(key, val)
                : null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private static boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);
    }

    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
