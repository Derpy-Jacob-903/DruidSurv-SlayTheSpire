package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static com.badlogic.gdx.math.MathUtils.random;
import static druidsurv.ModFile.makeID;

public class TripleDart extends AbstractEasyCard {
    public final static String ID = makeID("TripleDart");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public TripleDart() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 4;
        baseMagicNumber = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        ArrayList<AbstractMonster> temp =
                new ArrayList<>(AbstractDungeon.getCurrRoom().monsters.monsters);           // Get list of Monsters
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);                             // Deal normal damage to 1st target.
        temp.remove(m);                                                                     // Remove 1st target from list

        if (!temp.isEmpty())                                                                // Skip if list is empty
        {
            int j = random.nextInt(temp.size());                                            // Get a random target (index)
            AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);     // Get a random target (monster)
            attMagicNum(a, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);                    // Deal static damage to 2nd target.
            temp.remove(j);                                                                 // Remove 2nd target from list
        }
        if (!temp.isEmpty())                                                                // Skip if list is empty
        {
            int j = random.nextInt(temp.size());                                            // Get a new random target (index)
            AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);     // Get a new random target (monster)
            attMagicNum(a, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);                    // Deal static damage to 3rd target.
            temp.remove(j);                                                                 // Remove 3rd target from list
        }
    }

    @Override
    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(2);
    }
}