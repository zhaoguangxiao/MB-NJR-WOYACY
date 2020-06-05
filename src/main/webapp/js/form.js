// 请用原生js语法书写
// 依赖layui表单提交

/**
 * @return {boolean}
 */

const msgApi = "http://manage.4007123123.com/leave/insert.do";
//console.log("加载完成")

/**
 * @return {boolean}
 */
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break
        }
    }
    return flag;
}

const userEqt = IsPC() ? 0 : 1;
//console.log(userEqt);
let nowUrl = window.location.href;
let nowIp = returnCitySN["cip"];
layui.use(['layer', 'form'], function () {
    var layer = layui.layer, form = layui.form;
    form.render();
    form.verify({
        username: val => {
            if (val.length > 1000) {
                return "请输入正确的姓名"
            }
        }, address: value => {
            if (value.length > 1000) {
                return "请输入正确的地区"
            }
        }
    });

    form.on('submit(go)', data => {
        // 牛家人 17
        var category = 17
        var goForm = data.field;
        // console.log(goForm)
        let {username, phone, address} = goForm;
        // console.log(username)
        // console.log(phone)
        // console.log(address)
        // console.log(nowIp);
        // http://manage.zhou-yuanwai.com/
        // axios.post("http://manage.zhou-yuanwai.com/leave/insert.do?name=" + username + "&url=" + nowUrl + "&tell=" + phone + "&category=1&ip=" + nowIp + "&description=" + address + "&hasComputer=" + userEqt)

        var params = new URLSearchParams()
        params.append('district', address)
        params.append('url', nowUrl)
        params.append('ip', nowIp)
        params.append('category', category)
        params.append('hasComputer', userEqt)
        params.append('uname', username)
        params.append('phone', phone)
        axios.post(msgApi, params)
            .then(res => {
               // console.log(res.data.message);
                if (res.data.message === 200) {
                    layer.msg("发送成功，我们会尽快与您联系");

                    // 表单提交后设置所有输入框为空
                    let inps = document.querySelectorAll("input");
                    // console.log(inps)
                    inps.forEach(item => {
                        item.value = ""
                    });

                    // 判断是否有id为c-brn的按钮  在联系我们页面  若有，则改变样式  若无，则不操作
                    if (document.getElementById("c-btn")) {
                        // document.getElementById("c-btn").style.backgroundColor = "#e9493f"
                        document.getElementById("c-btn").style.backgroundColor = "rgb(244,157,22)"
                        document.getElementById("c-btn").innerText = "您已提交"
                    } else {
                       // console.log("么得")
                    }
                }

            }).catch(err => {
            layer.msg("错误，请再次提交")
        });
        return false
    })
});

//一般直接写在一个js文件中
layui.use(['layer', 'form', "element"], function () {
    var layer = layui.layer
        , form = layui.form
        , element = layui.element;
})

