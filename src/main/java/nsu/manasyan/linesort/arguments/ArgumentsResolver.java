package nsu.manasyan.linesort.arguments;

import com.google.devtools.common.options.OptionsParser;
import nsu.manasyan.linesort.exceptions.WrongArgumentException;

public class ArgumentsResolver {
    private static final int argsCount = 4;

    public static CommandLineOptions resolve(String[] args){
        OptionsParser optionsParser = OptionsParser.newOptionsParser(CommandLineOptionsData.class);
        optionsParser.parseAndExitUponError(args);

        CommandLineOptions commandLineOptions = new CommandLineOptions(optionsParser.getOptions(CommandLineOptionsData.class));
        commandLineOptions.getOptions().forEach(ArgumentsResolver::checkIsEmpty);

        if(args.length != argsCount){
            throw new WrongArgumentException("Wrong argument count, must be: " + argsCount);
        }

        commandLineOptions.setDirectoryPath(args[0]);
        return commandLineOptions;
    }

    private static void checkIsEmpty(String option){
        if(option.isEmpty()){
            throw new WrongArgumentException("Wrong argument value: " + option);
        }
    }
}
