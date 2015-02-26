

function Onclick()

	edit:setText("点击事件触发成功");
end
function onCreated()
    
	local root = view{Marginleft="0%",Margintop="0%",Width="100%",Height="100%",BackgroundColor="#ddeeff"}
    local subb = EditText{Id="edit",Marginleft="30%",Margintop="2%",Width="60%",Height="5%",BackgroundColor="#ffffff"}
    root:addChild(Button{Text="提交",Marginleft="30%",Margintop="30%",Width="40%",Height="5%",BackgroundColor="#eeccff",
    Onclick="Onclick"})

    root:addChild(subb)
    
	return  root
end