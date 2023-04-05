/*
Levenshtein distance using cpp=20 features

*/ 

template <typename StringA, typename StringB>
                requires std::ranges::sized_range<StringA> &&
                         std::ranges::sized_range<StringB> &&
                         std::ranges::random_access_range<StringA> &&
                         std::ranges::random_access_range<StringB> &&
                         std::same_as<std::ranges::range_value_t<StringA>, std::ranges::range_value_t<StringB>>
            std::size_t levenshtein(StringA const &a, StringB const &b)
            {

                // Creating two vectors both with equal size.
                //  one vector used for row and other used for column

                std::vector<std::size_t> row_vector0(std::ranges::size(b) + 1);
                std::vector<std::size_t> col_vector1(std::ranges::size(b) + 1);

                // using std::iota to initilize the vector to 0,1,2,3... till the size of vector row

                std::iota(std::ranges::begin(row_vector0), std::ranges::end(row_vector0), 0);
                for (std::size_t i = 0; i < std::ranges::size(a); ++i)
                {
                    col_vector1[0] = i + 1;
                    for (std::size_t j = 0; j < std::ranges::size(b); ++j)
                    {
                        std::size_t deletion_cost = row_vector0[j + 1] + 1; // calculating the deletion cost of an element in the vector
                        std::size_t insertion_cost = col_vector1[j] + 1;    // calculating the insertion cost on and element
                        std::size_t sub_cost = 0;                           // initilizing the substitution cost var to 0 and then computing it as per conditions
                        if (a[i] == b[j])
                        {
                            sub_cost = row_vector0[j];
                        }
                        else
                        {
                            sub_cost = row_vector0[j] + 1;
                        }
                        // calling the min function from our namespace to get the minimum of Deletion, insertion and substitution cost
                        col_vector1[j + 1] = uwindsor_2023w::comp3400::project::min(deletion_cost, insertion_cost, sub_cost);
                    }
                    // simply swaping the row and col vectors
                    std::swap(row_vector0, col_vector1);
                }
                // returing the right bottom most cell that is token edit score.
                return row_vector0[std::ranges::size(b)];
            }
