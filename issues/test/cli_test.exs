defmodule CliTest do

use ExUnit.Case
doctest Issues

import Issues.CLI

test "testing help on parse args" do
	assert parse_args(["--help", "abcd"]) == :help
end

test "testing author on parse args" do 
	assert parse_args(["--author"]) == {:author,"This code is developed by spbrds"}
end

test "testing the three full arguments" do
	assert parse_args(["spbrds","project_elixir","10"]) == {"spbrds","project_elixir",10}
end

test "without the number of issues" do
	assert parse_args(["spbrds","project_elixir"]) == {"spbrds","project_elixir",4}
end

#test "test the git fetching" do end

end