package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String tag;
    private TagInterface object;

    LabelTag(String tag, TagInterface object) {
        this.tag = tag;
        this.object = object;
    }
    public String render() {
        return "<label>" + tag + object.render() + "</label>";
    }
}
// END
