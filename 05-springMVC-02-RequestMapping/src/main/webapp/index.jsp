<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册页面</title>
</head>
<body>
<form method="post" action="/user/register">
  <table align="center">
    <caption><h1 align="center">注册</h1></caption>
    <tr>
      <td>姓名</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>年龄</td>
      <td><input type="text" name="age"></td>
    </tr>
    <tr>
      <td>性别</td>
      <td>
        男<input type="radio" name="gender" value="男">
        女<input type="radio" name="gender" value="女" checked>
      </td>
    </tr>
    <tr>
      <td>生日</td>
      <td><input type="date" name="birthday"></td>
    </tr>
    <tr>
      <td>信息</td>
      <td><input type="text" name="info"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交">
      </td>
    </tr>
  </table>
</form>
</body>
</html>