package com.pluralsight.speldemo;

import com.pluralsight.speldemo.data.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {

    public static void main(String[] args) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression1 = spelExpressionParser.parseExpression("'Hello World'");
        String message = expression1.getExpressionString();
        System.out.println(message);

        Expression expression2 = spelExpressionParser.parseExpression("'Hello'.length()");
        System.out.println(expression2.getValue());

        Expression expression3 = spelExpressionParser.parseExpression("'Hello'.length() * 10");
        System.out.println(expression3.getValue());

        Expression expression4 = spelExpressionParser.parseExpression("'Hello'.length() > 4");
        System.out.println(expression4.getValue());

        //***************************************************************************************//

        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setVariable("greeting", "Hello India");
        String msg = (String) spelExpressionParser.parseExpression("#greeting.substring(6)").getValue(standardEvaluationContext);
        System.out.println(msg);

        StandardEvaluationContext standardEvaluationContext2 = new StandardEvaluationContext();
        standardEvaluationContext2.setVariable("greeting", "Hello USA");
        String msg2 = (String) spelExpressionParser.parseExpression("#greeting.substring(6)").getValue(standardEvaluationContext2);
        System.out.println(msg2);

        User user = new User("US", "En");
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);
        spelExpressionParser.parseExpression("country").setValue(userContext, "India");
        System.out.println(user.getCountry());

        spelExpressionParser.parseExpression("language").setValue(userContext, "hindi");
        System.out.println(user.getLanguage());

        spelExpressionParser.parseExpression("timeZone").setValue(userContext, "Asia/Kolkata");
        System.out.println(user.getTimeZone());


        StandardEvaluationContext propsContext = new StandardEvaluationContext();
        propsContext.setVariable("systemProperties",System.getProperties());
        Expression expCountry = spelExpressionParser.parseExpression("#systemProperties['user.country']");
        spelExpressionParser.parseExpression("country").setValue(userContext,expCountry.getValue(propsContext));
        System.out.println(user.getCountry());

        Expression expLanguage = spelExpressionParser.parseExpression("#systemProperties['user.language']");
        spelExpressionParser.parseExpression("language").setValue(userContext,expLanguage.getValue(propsContext));
        System.out.println(user.getLanguage());

        Expression expTimeZone = spelExpressionParser.parseExpression("#systemProperties['user.timezone']");
        spelExpressionParser.parseExpression("timeZone").setValue(userContext,expTimeZone.getValue(propsContext));
        System.out.println(user.getTimeZone());
    }
}
