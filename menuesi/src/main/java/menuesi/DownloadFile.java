/**
 * 
 */
package menuesi;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * @author krosf
 *
 */
public class DownloadFile extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		try {
			String url_str = message.getPayloadAsString();
			URL url = new URL(url_str);
			File file = new File("images/" + FilenameUtils.getBaseName(url.getPath()));
			FileUtils.copyURLToFile(url, file);
			return file;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}
}
