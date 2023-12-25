import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.editor.Editor;

public class plagiin1007 extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent Action) {
        if (Messages.showYesNoDialog("Share in Telegram message?", "Is Sharing", Messages.getQuestionIcon()) != 0) {
            return;
        }
        Editor editor = Action.getData(PlatformDataKeys.EDITOR);
        String code = editor.getSelectionModel().getSelectedText();
        //String code = anActionEvent.getData(PlatformDataKeys.FILE_TEXT);

        if (code == null) {
            Messages.showErrorDialog("Text is not selected", "It will be not sent");
            return;
        }

        String url = String.format("https://telegram.me/share/url?url=```%s```", code);

        BrowserUtil.browse(url);
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
