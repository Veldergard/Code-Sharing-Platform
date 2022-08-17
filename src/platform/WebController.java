package platform;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class WebController {
    private List<Code> code = new ArrayList<>();

    public WebController() {
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<List<Code>> getLatestCodeApi() {
        List<Code> latest = new ArrayList<>();
        for (int i = code.size() - 1; i >= 0 && latest.size() < 10; i--) {
            latest.add(code.get(i));
        }
        return new ResponseEntity<>(latest, HttpStatus.OK);
    }

    @GetMapping(value = "/code/latest", produces = MediaType.TEXT_HTML_VALUE)
    public String getLatestCodeWeb(Model model) {
        model.addAttribute("title", "Latest");
        List<Code> latest = new ArrayList<>();
        for (int i = code.size() - 1; i >= 0 && latest.size() < 10; i--) {
            latest.add(code.get(i));
        }
        model.addAttribute("codeList", latest);
        return "code";
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity<Code> getCodeApi(@PathVariable int id) {
        id -= 1;
        if (id >= 0 && id < code.size()) {
            return new ResponseEntity<>(code.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/code/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCodeWeb(Model model, @PathVariable int id) {
        id -= 1;
        if (id >= 0 && id < code.size()) {
            List<Code> codeList = new ArrayList<>();
            codeList.add(code.get(id));
            model.addAttribute("title", "Code");
            model.addAttribute("codeList", codeList);
            return "code";
        }
        return null;
    }

    @PostMapping("/api/code/new")
    public ResponseEntity<Map<String, String>> postNewCode(@RequestBody Code code) {
        this.code.add(code);
        return new ResponseEntity<>(Map.of("id", String.valueOf(this.code.size())), HttpStatus.OK);
    }

    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public String getNewCodePage() {
        return "code_new";
    }
}
