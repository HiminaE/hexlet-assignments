package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }
    @Override
    public String toString() {
        if (getAttributes().isEmpty()) {
            return "<" + this.getName() + ">" + body + "</" + this.getName() + ">";
        } else if (!getChildren().isEmpty()) {
            return "<" + this.getName() + " " + this.attributesToString() + ">"
                    + this.getChildren() + body + "</" + this.getName() + ">";
        } else {
            return "<" + this.getName() + " " + this.attributesToString() + ">"
                    + body + "</" + this.getName() + ">";
        }
    }

    public String getChildren() {
        String result = children.stream()
                .map(a -> "<" + a.getName() + " " + a.attributesToString() + ">")
                .collect(Collectors.joining(""));
        return result.trim();
    }
}
// END
