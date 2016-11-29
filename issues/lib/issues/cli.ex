defmodule Issues.CLI do

@default_count 4
@author "spbrds"
	
@moduledoc """
Handle the command line by parsing the arguments and call
the correspondent function
"""

	def run(args), do: parse_args(args)
		

	def parse_args(args) do
		parse = OptionParser.parse(args, switches: [help: :boolean, author: :boolean],
										 aliases: [h: :help, a: :author])
										 
		case parse do
		
			{[help: true], _ , _} -> :help
			{[author: true], _ ,_} -> @author
			{_, [user, project, count], _} -> {user, project, count}
			{_, [user, project], _} -> {user, project, @default_count}
			_ -> :help
		
		end


	end

end