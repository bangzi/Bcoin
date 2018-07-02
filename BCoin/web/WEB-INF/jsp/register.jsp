<%--
  Created by IntelliJ IDEA.
  User: fenghaibang
  Date: 2018/6/20
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>register</title>

    <style>
        .detail p{width:100%;font-size:14px; color:#353535; text-indent:28px; padding-bottom:10px; line-height:30px; padding:5px 0;}
        #tabRegister .td1 {width:37%; text-align:right;font-size:16px;}/*注册委员*/
        #tabRegister .td2 { text-align:left;}
        #tabRegister .textInput { border-width:1px;border-style:solid;border-radius:5px;border-color:#0094ff; height:25px;width:220px}
        #tabRegister .trHight { height:50px;line-height:50px;}/*注册委员*/
    </style>

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>

<div class="width100 marT15 content_news_list">
    <div class="width96 mauto">
        <div class="width100" >
            <form id="userRegister">
            <%--<div style="margin-top: 60px; text-align: center">--%>
                <%--<p style="font-size: 30px">欢迎注册 B Coin </p>--%>
            <%--</div>--%>
            <table style="width:100%" id="tabRegister">
                <tr style="height: 100px; line-height: 100px">
                    <td class="td1">
                    </td>
                    <td style="margin-top: 20px; text-align: left; font-size: 30px">
                        欢迎注册 B Coin 
                    </td>
                </tr>
                <%--<tr class="trHight">--%>
                    <%--<td class="td1">--%>
                        <%--用户名 --%>
                    <%--</td><!--用户名信息验证-->--%>
                    <%--<td  class="td2"><input type="text" id="inp_user" class="textInput" onblur="m_userTipOnblur();"  />--%>
                        <%--&lt;%&ndash;<span id="span_userTip" style="color:#f00;display:inline-block;" >*</span>&ndash;%&gt;--%>
                    <%--</td><!--用户名信息验证-->--%>
                <%--</tr>--%>

                <tr class="trHight">
                    <td class="td1">
                        手机号
                    </td>
                    <td  class="td2"><input type="text" id="inp_phone" class="textInput" name="userPhone"/>
                        <%--<span style="color:#f00">*</span>--%>
                        <%--<span id="span_nameTip"  style="color:#f00;display:none;" ></span>--%>
                    </td>
                </tr>
                <tr class="trHight">
                    <td class="td1">
                        密码 
                    </td><!--密码信息验证-->
                    <td  class="td2"><input type="password" id="asp_psw" class="textInput" TextMode="Password" name="userPassword"/>
                        <%--<span style="color:#f00">*</span>--%>
                        <%--<span id="span_PasswordTip"  style="color:#f00;display:none;" ></span>--%>
                    </td><!--密码信息验证-->
                </tr>
                <tr class="trHight">
                    <td class="td1">
                        确认密码 
                    </td><!--确认密码信息验证-->
                    <td  class="td2"><input type="password" id="asp_cpsw" class="textInput" TextMode="Password" name="userConfirmPassword"/>
                        <%--<span style="color:#f00">*</span>--%>
                        <%--<span id="span_ConfirmPasswordTip" style="color:#f00;display:none;"></span>--%>
                    </td><!--确认密码信息验证-->
                </tr>
                <tr class="trHight">
                    <td class="td1">
                        邀请码
                    </td><!--职称-->
                    <td  class="td2"><input type="text" id="inp_code" class="textInput" name="requestCode"/>
                        <%--<span style="color:#f00">*</span>--%>
                        <%--<span id="inp_codeTip"  style="color:#f00;display:none;" ></span>--%>
                    </td><!--职称-->
                </tr>

                <tr  style="height:70px;line-height:70px;">
                    <td class="td1">
                    </td>
                    <td  class="td2" style="padding-top :10px;" >
                        <%--<input type="button" id="inp_button_register" class="textInput" value="注        册" style="height: 40px; font-size: 16px; background-color: #4cae4c" onclick="registerUser()" />--%>
                        <button id="inp_button_register" class="textInput" style="background-color: #4cae4c; font-size: 16px; height: 40px; " onclick="registerUser()">注  册</button>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="<%=basePath%>js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath%>js/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=basePath%>js/sb-admin-2.js"></script>

<!--validate.js是建立在jquery之上的，所以得先导入jquery的类库-->
<script type="text/javascript" src="<%=basePath%>js/jquery.validate.min.js" ></script>
<!--引入国际化js文件-->
<script type="text/javascript" src="<%=basePath%>js/messages_zh.js" ></script>

<script type="text/javascript">

    $(function(){
        $("#userRegister").validate({
            rules:{
                userPassword: {
                    required:true,
                    digits:true,
                    minlength:6
                },
                userConfirmPassword: {
                    required:true,
                    equalTo:"[name='userPassword']"
                }
            },
            messages:{
                userPassword: {
                    required: "密码不能为空!",
                    digits: "密码必须是整数!",
                    minlength: "密码不得少于6位!"
                },
                userConfirmPassword:{
                    required:"确认密码不能为空!",
                    equalTo:"两次输入密码不一致!"
                },

            }
        });
    });

    //注册
    function  registerUser() {
        var m_inp_phone =  $("#inp_phone").val();//用户名的值

        var m_asp_psw = $("#asp_psw").val();//密码的值
        var m_asp_cpsw = $("#asp_cpsw").val();//确认密码的值
        var m_inp_code = $("#inp_code").val();//邀请码的值,并进行编码
        if (m_inp_phone == "" || m_asp_psw == "" || m_asp_cpsw == "" || m_inp_code == "") {
            alert("请把注册信息填写完整");
            return;
        };
        if (m_asp_psw != m_asp_cpsw) {
            return;
        };
        if (!isPoneAvailable(m_inp_phone)) {
            alert("手机号填写有误，请确认");
            return;
        };

        $.post("<%=basePath%>Bcoin/register.action",$("#userRegister").serialize(),function(data){
            alert("客户信息更新成功！" + data.code);
        });


        <%--$.ajax({--%>
            <%--type:"post",--%>
            <%--url:"<%=basePath%>customer/register.action",--%>
            <%--data: {"userPhone":"123", "userPassword":m_asp_psw, "requestCode" : m_inp_code},--%>
            <%--success:function(data) {--%>
                <%--alert(data);--%>
            <%--}--%>
        <%--});--%>
    };

    // 判断是否为手机号
    function isPoneAvailable(pone) {
        var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (!myreg.test(pone)) {
            return false;
        } else {
            return true;
        }
    }

</script>

</body>
</html>



