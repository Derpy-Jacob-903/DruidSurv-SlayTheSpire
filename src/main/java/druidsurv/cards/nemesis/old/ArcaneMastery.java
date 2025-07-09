package druidsurv.cards.nemesis.old;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.NemCharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.WizardPower;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

@AutoAdd.Ignore
@Deprecated
public class ArcaneMastery extends AbstractEasyCard {
    public final static String ID = makeID("ArcaneMastery");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public ArcaneMastery() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CharacterFile.Enums.NEMDRUID_COLOR, "Defend");
        baseMagicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(p(), p(), new WizardPower(p(), magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}