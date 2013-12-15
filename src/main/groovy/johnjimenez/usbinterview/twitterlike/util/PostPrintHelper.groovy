package johnjimenez.usbinterview.twitterlike.util

class PostPrintHelper {

    static getStringBuilder(List posts, Closure getStringBuilderComponent) {
        StringBuilder sb = new StringBuilder('\n')
        posts.each {
            sb.append "${getStringBuilderComponent(it)}\n"
        }
        sb
    }
}
