View = {}
View.__index = View

function View:addChild(child)
    local sub = self.subitems
    if not sub then
        sub = {}
        self.subitems = sub
    end
    
    table.insert(sub, child)
end

function view(args)
    local m = {}
    setmetatable(m, View)
    m.qName = "view"
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function edittext(args)
    local m = {}
    m.qName = "edittext"
    m.height = 44
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function button(args)
    local m = {}
    m.qName = "button"
    m.height = 44
    if args then
    	for k,v in pairs(args) do
    		m[k] = v
    	end
    end
    return m
end
function table2json(t)   
        local function serialize(tbl)   
                local tmp = {}   
                for k, v in pairs(tbl) do   
                        local k_type = type(k)   
                        local v_type = type(v)   
                        local key = (k_type == "string" and "\"" .. k .. "\":")   
                            or (k_type == "number" and "")   
                        local value = (v_type == "table" and serialize(v))   
                            or (v_type == "boolean" and tostring(v))   
                            or (v_type == "string" and "\"" .. v .. "\"")   
                            or (v_type == "number" and v)   
                        tmp[#tmp + 1] = key and value and tostring(key) .. tostring(value) or nil   
                end   
                if table.maxn(tbl) == 0 then   
                        return "{" .. table.concat(tmp, ",") .. "}"  
                else   
                        return "[" .. table.concat(tmp, ",") .. "]"  
                end   
        end   
        assert(type(t) == "table")   
        return serialize(t)   
end  