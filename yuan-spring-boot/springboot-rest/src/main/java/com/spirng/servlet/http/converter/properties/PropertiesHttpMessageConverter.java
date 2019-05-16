package com.spirng.servlet.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties }{@link org.springframework.http.converter.HttpMessageConverter}实现。
 * @ClassName PropertiesHttpMessageConverter
 * @Author Administrator
 * @Date 2019/5/3 11:17
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {
//设置支持的MediaType。
    public  PropertiesHttpMessageConverter()
    {
        super(new MediaType("text","properties"));
    }
    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        //从请求头Content-Type解析编码。
        HttpHeaders httpHeaders = httpOutputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        //获取字符编码。
        Charset charset = mediaType.getCharset();
        //当charset不存在时使用utf-8。
        charset = charset == null?Charset.forName("UTF-8"):charset;

        //properties->String。
        //OutputStream - >Writer.
        //字节输出流。
        OutputStream outputStream =  httpOutputMessage.getBody(); //字符流-》字符编码。
        //字符输出流。
        Writer writer = new OutputStreamWriter(outputStream);
        //Properties写入到字符输出流。
        properties.store(writer,"From PropertiesHttpMessageConverter");
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {

        //字符流-》字符编码。
        //从请求头Content-Type解析编码。
        HttpHeaders httpHeaders = httpInputMessage.getHeaders();
        MediaType mediaType = httpHeaders.getContentType();
        //获取字符编码。
        Charset charset = mediaType.getCharset();
        //当charset不存在时使用utf-8。
        charset = charset == null?Charset.forName("UTF-8"):charset;

        // 字节流。
        InputStream inputStream = httpInputMessage.getBody();

        InputStreamReader reader = new InputStreamReader(inputStream,charset);

        Properties properties = new Properties();
        //加载字符流。成为properties对象。
        properties.load(reader);

        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null,httpInputMessage);
    }
}
