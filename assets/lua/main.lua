

function Onclick()

	edit:setText("点击事件触发成功");
end
function onCreated()
    
	local root = view{id="1",marginleft="0%",margintop="0%",width="100%",height="500%",backgroundcolor="#debbff"}
    root:addChild(view{id="2",marginleft="0%",margintop="0%",width="30%",height="500%",backgroundcolor="#eeccff",
    onclick="Onclick"})

   -- root:addChild(subb)
       root:addChild(view{id="3",marginleft="60%",margintop="30%",width="30%",height="200%",backgroundcolor="#000000",
    })
    
	return  root
end