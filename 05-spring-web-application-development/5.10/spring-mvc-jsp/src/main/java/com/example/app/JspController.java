package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JspController {
    
    @GetMapping("scriptlet")
    public String scriptlet(){
    	return "scriptlet";
    }
    
    @GetMapping("taglib")
    public String taglib(){
    	return "taglib";
    }
    
    @GetMapping("tagfile")
    public String tagfile(){
    	return "tagfile";
    }
    
    @GetMapping("el")
    public String el(){
    	return "el";
    }
    
    @GetMapping("elfunction")
    public String elfunction(){
    	return "elfunction";
    }
    
    @GetMapping("jstl")
    public String jstl(){
    	return "jstl";
    }

    @ModelAttribute("hobbyCodeList")
    public Map<String,String> hobbyCodeList(){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("sport", "スポーツ");
        map.put("movie", "映画");
        map.put("music", "音楽");
        return map;
    }

    @ModelAttribute("hobbyCollection")
    public Collection<String> hobbyCollection(@ModelAttribute("hobbyCodeList") Map<String, String> hobbyCodeList){
        return new ArrayList<>(hobbyCodeList.values());
    }
    
    @ModelAttribute("messageString")
    public String messageString(){
        return "こんにちは！";
    }

    @ModelAttribute("message")
    public Message message(){
    	Message message = new Message();
    	message.setText("ご利用ありがとうございます。");
        return message;
    }
    
    @ModelAttribute("messages")
    public List<Message> messages(@ModelAttribute("message") Message message){
    	List<Message> messages = new ArrayList<Message>();
    	messages.add(message);
        return messages;
    }
    
    @ModelAttribute("messagesMap")
    public Map<String, String> messagesMap(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	map.put("guidance.termsOfUse", "利用規約");
        return map;
    }
    
    @ModelAttribute("form")
    public Form form(){
    	Form form = new Form();
    	form.setMemo("\"></script><script>alert(0)</script>");
        return form;
    }
}
