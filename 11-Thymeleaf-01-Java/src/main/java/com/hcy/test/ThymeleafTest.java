package com.hcy.test;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafTest {
    // 测试非web环境下使用thymeleaf
    @Test
    public void testRenderSStaticData(){
        //从创建一个模板引擎对象
        //万物皆对象，使用TemplateEngine对象完成后续的操作
        TemplateEngine engine = new TemplateEngine();

        //准备一个模板
        //th:value是模板殷勤所支持的属性标签
        //能够被thymeleaf所识别
        //有一点类似jstl中扩展的标签
        //被th:value的内容就是我们刚刚提到的占位符
        //可以给占位符传递参数并且替换掉
        //替换后的效果和value属性是一样的
        String template="<input type='text'  th:value='易烊千玺'>";

        //准备一个上下文的环境
        Context context = new Context();

        //使用模板引擎去处理模板
        //获取处理好的的页面
        String html = engine.process(template, context);

        System.out.println(html);
    }

    //测试渲染动态数据
    @Test
    public void testRenderDynamicData(){
        //准备一个模板引擎对象
        TemplateEngine templateEngine = new TemplateEngine();

        //准备一个动态模板
        //注意，把静态的数据使用${}的方式变成动态占位符，等会可以传递参数
        //外面的th:value就能够被模板引擎所识别，并替换
        String template="<input type='text' th:value='${name}'>";

        //创建一个环境对象
        //就类似于jsp中的ServletContext
        Context context = new Context();

        //设置占位符所对应的参数
        //当成域对象.setAttribute(ley,value)
        context.setVariable("name","马儿扎哈");

        //渲染模板
        String html=templateEngine.process(template, context);

        System.out.println(html);
    }

    //测试直接渲染html页面
    @Test
    public void testRenderHtml(){
        //创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        //这个时候不需要准备模板了，但是需要加载html
        //所以这个时候需要准备一个html的解析器
        //这个解析器就能够解析html页面
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        //给引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();

        context.setVariable("name","李豪爱蜥蜴");

        //直接传递一个路径和环境对象就行了
        String html=engine.process("index.html",context);

        System.out.println(html);
    }

    //如果我们有很对公共的前后缀可以通过这种方式来手动设置前后缀
    @Test
    public void testPrefixAndSuffix(){
        //创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        //准备一个文件解析器来解析html
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        //设置前后缀
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");

        //给模板引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();

        context.setVariable("name","鱼香肉丝");

        //获取渲染后的html页面
        //因为我们手动设置了前后缀，所以只需要使用文件名即可
        String html= engine.process("main",context);

        System.out.println(html);
    }
}
