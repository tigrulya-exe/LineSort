package nsu.manasyan.linesort.arguments;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

public class CommandLineOptionsData extends OptionsBase {

    @Option(name = "out-prefix",
            help = "Prefix, which'll be added to the beginning of the sorted files",
            category = "required",
            defaultValue = "")
    public String outPrefix;

    @Option(name = "content-type",
            help = "Type of file content",
            category = "required",
            defaultValue = "")
    public String contentType;

    @Option(name = "sort-mode",
            category = "required",
            help = "Ascending or descending order\n\nExecution template: java -jar *jar-file path* " +
                    "[path to directory of files to be sorted] [other options]",
            defaultValue = "")
    public String sortMode;
}
