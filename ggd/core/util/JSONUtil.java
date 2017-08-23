package ggd.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import baytony.util.Util;
import ggd.core.CoreException;
import ggd.core.common.CodeMsg;

/**
 * 提供JSON轉換功能的工具程式.
 * 主要是針對String to JsonNode及Object to Json String的相關轉換功能.
 * 
 * @author tonyyang
 *
 */
/**
 * @author tonyyang
 *
 */
public class JSONUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 取得{@code JsonNode}裡, attr的value值, 如果{@code JsonNode}裡沒有attr時, 救回傳預設的defValue.
	 * @param node
	 * @param attr
	 * @param defValue
	 * @return
	 */
	public static String getStringDef(JsonNode node, String attr, String defValue){
		return node.has(attr) ? node.get(attr).asText() : defValue;
	}
	
	/**
	 * 取得{@code JsonNode}裡, attr的value值, 如果{@code JsonNode}裡沒有attr時, 救以code產生Exception.
	 * @param node
	 * @param key
	 * @param code
	 * @return
	 * @throws RHException
	 */
	public static String getString(JsonNode node, String attr, String code) throws CoreException{
		if(node.has(attr)){
			return node.get(attr).asText();
		} else {
			if(Util.isEmpty(code)){
				throw new CoreException(CodeMsg.JO_100);
			} else {
				throw new CoreException(code);
			}
		}	
	}
	
	/**
	 * Parser source裡的資訊並產生{@code JsonNode}物件. 
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(byte[] source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 *  Parser source裡的資訊並產生{@code JsonNode}物件. 
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(File source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 *  Parser source裡的資訊並產生{@code JsonNode}物件. 
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(InputStream source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(Reader source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 *  Parser source裡的資訊並產生{@code JsonNode}物件. 
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(String source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 *  Parser source裡的資訊並產生{@code JsonNode}物件. 
	 * @param source
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode parser(URL source) throws JsonProcessingException, IOException{
		return mapper.readTree(source);
	}
	
	/**
	 * 將傳入的物件, 轉換成JSON String的資訊.
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String toJsonString(Object obj) throws Exception{
		return mapper.writeValueAsString(obj);
	}

}
