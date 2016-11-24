defmodule CliTest do

use ExUnit.Case
doctest Issues

import Issues.CLI

test: "testing help on parse args" do
	assert parse_args(["--help", "abcd"]) == :help
end


end