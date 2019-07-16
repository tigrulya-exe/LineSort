package nsu.manasyan.linesort.arguments;

import com.google.devtools.common.options.OptionsParser;
import nsu.manasyan.linesort.exceptions.WrongArgumentException;

public class ArgumentsResolver {
    public static CommandLineOptions checkArgs(String[] args){
        OptionsParser optionsParser = OptionsParser.newOptionsParser(CommandLineOptionsData.class);
        optionsParser.parseAndExitUponError(args);

        CommandLineOptions commandLineOptions = new CommandLineOptions(optionsParser.getOptions(CommandLineOptionsData.class));

        if(args.length != 4 || commandLineOptions.getOutPrefix().isEmpty() || commandLineOptions.getContentType().isEmpty() || commandLineOptions.getSortMode().isEmpty()){
            throw new WrongArgumentException("Wrong arguments");
        }

        commandLineOptions.setDirectoryPath(args[0]);

        return commandLineOptions;
    }
}
