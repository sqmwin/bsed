package cn.bsed.converter;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author SQM
 * @date 2018/1/18
 * @version: 1.0
 */
public class MyDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            String nothing = "";
            if (s != null && !nothing.equals(s.trim())) {
                SimpleDateFormat simpleDateFormat = getSimpleDataFormat(s);
                return simpleDateFormat.parse(s);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getSimpleDataFormat(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format1 = "^\\d{4}-\\d{2}-\\d{2}$";
        String format2 = "^\\d{4}/\\d{2}/\\d{2}$";
        String format3 = "^\\d{4}\\d{2}\\d{2}$";
        if (Pattern.matches(format1, s)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if (Pattern.matches(format2, s)) {
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        } else if (Pattern.matches(format3, s)) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        } else{
            throw new TypeMismatchException("", Date.class);
        }
        return simpleDateFormat;
    }
}
