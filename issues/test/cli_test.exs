defmodule CliTest do

use ExUnit.Case
doctest Issues

import Issues.CLI

test "testing help on parse args" do
	assert parse_args(["--help", "abcd"]) == :help
end

test "testing author on parse args" do 
	assert parse_args(["--author"]) == "spbrds"
end

end