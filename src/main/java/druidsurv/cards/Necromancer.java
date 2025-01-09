package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.WizardPower;
import druidsurv.powers.strengthenator;

import static druidsurv.ModFile.makeID;

public class Necromancer extends AbstractEasyCard {
    public final static String ID = makeID("WizardMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Necromancer() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new strengthenator(p, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}