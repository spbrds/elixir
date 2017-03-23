defmodule Issues.CLI do

@default_count 4
@author "spbrds"
	
@moduledoc """
Handle the command line by parsing the arguments and call
the correspondent function
"""

	def run(args), do: 
		args |> parse_args
				|>process
		

	def parse_args(args) do
		parse = OptionParser.parse(args, switches: [help: :boolean, author: :boolean],
										 aliases: [h: :help, a: :author])
										 
		case parse do
		
			{[help: true], _ , _} -> :help
			{[author: true], _ ,_} -> {:author,"This code is developed by #{@author}"}
			{_, [user, project, count], _} -> {user, project, String.to_integer(count)}
			{_, [user, project], _} -> {user, project, @default_count}
			_ -> :help
		
		end
	end
	
	def process(:help) do
		IO.puts """
			usage: issues <user> <project_name> [count | #{@default_count}
		"""
		System.halt(0)
	end
	
	def process({:author, message}) do
		IO.puts message
		System.halt(0)
	end
	
	#def process(

end