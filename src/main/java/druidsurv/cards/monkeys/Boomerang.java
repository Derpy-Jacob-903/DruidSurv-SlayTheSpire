package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static com.badlogic.gdx.math.MathUtils.random;
import static druidsurv.ModFile.makeID;

public class Boomerang extends AbstractEasyCard {
    public final static String ID = makeID("Boomerang");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Boomerang() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, "BoomerangMonkey_CardArt");
        baseDamage = 8;
        baseMagicNumber = magicNumber = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        //dmgRandom(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < temp; j++) {
                AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
                if (a == m)
                {
                    dmg(a, AbstractGameAction.AttackEffect.SLASH_VERTICAL); // Deal normal damage.
                }
                else
                {
                    altDmg(a, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL); // Otherwise damage based on secondDamage.
                }
            }
        };

        /*ArrayList<AbstractMonster> temp =
                new ArrayList<>(AbstractDungeon.getCurrRoom().monsters.monsters);           // Get list of Monsters
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);                             // Deal normal damage to 1st target.
        temp.remove(m);                                                                     // Remove 1st target from list

        if (!temp.isEmpty())                                                                // Skip if list is empty
        {
            int j = random.nextInt(temp.size());                                            // Get a random target (index)
            AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);     // Get a random target (monster)
            attMagicNum(a, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);                    // Deal static damage to 2nd target.
            temp.remove(j);                                                                 // Remove 2nd target from list
        }*/
    }

    @Override
    public void upp() {
        upgradeDamage(3);
        upgradeMagicNumber(1);
    }
}