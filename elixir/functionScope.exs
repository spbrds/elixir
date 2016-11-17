printConcatenateTwoStrings = fn title -> (fn name -> IO.puts("#{title} #{name}") end) end

(:ok) = printConcatenateTwoStrings.("Senhor").("Simão")
firstOcus = printConcatenateTwoStrings.("Ocus")
:ok = firstOcus.("Pocus")

concatenateTwoStrings = fn str1 -> fn str2 -> "#{str1} #{str2}" end end
ve = concatenateTwoStrings.("vou-me").("embora")

IO.puts(ve)

"vou-me embora" = ve


