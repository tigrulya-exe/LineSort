package nsu.manasyan.linesort.arguments;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

public class CommandLineOptionsData extends OptionsBase {

    @Option(name = "out-prefix",
            help = "Prefix, which'll be added to the beginning of the sorted files",
            defaultValue = "")
    public String outPrefix;

    @Option(name = "content-type",
            help = "Type of file content",
            defaultValue = "")
    public String contentType;

    @Option(name = "sort-mode",
            help = "Ascending or descending order",
            defaultValue = "")
    public String sortMode;
}
